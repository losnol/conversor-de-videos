package br.com.app.input;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import br.com.app.login.credenciais.Credencials;
import br.com.app.login.credenciais.S3Sizes;
import br.com.app.utils.servletFileUploadUtils;

@MultipartConfig
public class VideoRaw extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LogManager.getLogger(VideoRaw.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.setsetHeadersInfo(resp);

		if (!ServletFileUpload.isMultipartContent(req)) {
			RequestDispatcher rd = req.getRequestDispatcher("error");
			rd.include(req, resp);
			return;
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(S3Sizes.THRESHOLD_SIZE.getSizeValue());

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(S3Sizes.MAX_FILE_SIZE.getSizeValue());
		upload.setSizeMax(S3Sizes.MAX_REQUEST_SIZE.getSizeValue());

		String uuidValue = "";
		FileItem video = null;
		String keyName = "";

		try {
			List<?> formItems = upload.parseRequest(req);
			@SuppressWarnings("unchecked")
			Iterator<List<?>> iter = (Iterator<List<?>>) formItems.iterator();

			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {
					if (item.getFieldName().equalsIgnoreCase("uuid")) {
						uuidValue = item.getString();
					}
				}
				if (!item.isFormField()) {
					video = item;
				}
			}

			BasicAWSCredentials awsCredentials = new BasicAWSCredentials(Credencials.AMAZON_ACCESS_KEY.toString(),
					Credencials.AMAZON_SECRET_KEY.toString());

			@SuppressWarnings("deprecation")
			AmazonS3 s3client = new AmazonS3Client(awsCredentials);
			try {
				keyName = servletFileUploadUtils.uploadAWS_S3(video, uuidValue, s3client);
			} catch (AmazonServiceException ase) {
				LOGGER.error(uuidValue + ":error:" + ase.getMessage());
			} catch (AmazonClientException ace) {
				LOGGER.error(uuidValue + ":error:" + ace.getMessage());
			}
		} catch (Exception ex) {
			LOGGER.error(uuidValue + ":" + ":error: " + ex.getMessage());
		}
		LOGGER.info(uuidValue + ":Upload done");
		req.setAttribute("link",keyName);
		RequestDispatcher rd = req.getRequestDispatcher("videoconvertido");
		rd.forward(req, resp);
		return;	} 

	private HttpServletResponse setsetHeadersInfo(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
		return resp;
	}

	@RequestMapping(value = "/uuid", method = RequestMethod.GET)
	@ResponseBody
	public String getUuid(final HttpServletResponse response) {
		response.setContentType("text/javascript; charset=UTF-8");
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		LOGGER.info("UUID:" + uuid);
		return uuid;
	}
}
