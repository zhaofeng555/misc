package action.chainofresponsibility.handler;

import action.chainofresponsibility.request.AddMoneyRequest;
import action.chainofresponsibility.request.Request;

public class PMRequestHandler implements RequestHandle {

	RequestHandle rh;
	
	public PMRequestHandler(RequestHandle rh){
		this.rh=rh;
	}
	
	@Override
	public void handleRequest(Request request) {
		if(request instanceof AddMoneyRequest)
			System.out.println("加薪，经理审批！");
		else
			rh.handleRequest(request);
	}

}
