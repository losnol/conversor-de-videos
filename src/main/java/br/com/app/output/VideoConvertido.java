package br.com.app.output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brightcove.zencoder.client.ZencoderClient;
import com.brightcove.zencoder.client.ZencoderClientException;
import com.brightcove.zencoder.client.model.ContainerFormat;
import com.brightcove.zencoder.client.request.ZencoderCreateJobRequest;
import com.brightcove.zencoder.client.request.ZencoderOutput;
import com.brightcove.zencoder.client.response.ZencoderCreateJobResponse;

public class VideoConvertido extends HttpServlet {

	private static final long serialVersionUID = 1L; 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ZencoderClient client = new ZencoderClient("4529d94d1c328d548481c028596adae4");
		ZencoderCreateJobRequest job = new ZencoderCreateJobRequest();
		job.setInput((String) req.getAttribute("link"));
		System.out.println((String) req.getAttribute("link"));
		List<ZencoderOutput> outputs = new ArrayList<ZencoderOutput>();

		ZencoderOutput output1 = new ZencoderOutput();
		output1.setFormat(ContainerFormat.MP4);
		outputs.add(output1);

		ZencoderOutput output2 = new ZencoderOutput();
		output2.setFormat(ContainerFormat.WEBM);
		outputs.add(output2);

		job.setOutputs(outputs);
		ZencoderCreateJobResponse response = null;
		try {
			response = client.createZencoderJob(job);
		} catch (ZencoderClientException e) {
			e.printStackTrace();
		}
		req.setAttribute("urlvideo",response.getOutputs().get(0).getUrl());
		RequestDispatcher rd = req.getRequestDispatcher("confirmacaovideo.jsp");
		rd.forward(req, resp);
		return;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
