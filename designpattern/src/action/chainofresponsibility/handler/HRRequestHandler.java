package action.chainofresponsibility.handler;

import action.chainofresponsibility.request.DimissionRequest;
import action.chainofresponsibility.request.Request;

public class HRRequestHandler implements RequestHandle {

	@Override
	public void handleRequest(Request request) {
		if (request instanceof DimissionRequest)
			System.out.println("要离职，人事审批！");

		System.out.println("完事了");
	}

}
