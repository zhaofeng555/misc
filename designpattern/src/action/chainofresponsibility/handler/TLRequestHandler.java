package action.chainofresponsibility.handler;

import action.chainofresponsibility.request.LeaveRequest;
import action.chainofresponsibility.request.Request;

public class TLRequestHandler implements RequestHandle {

	RequestHandle rh;
	
	public TLRequestHandler(RequestHandle rh){
		this.rh=rh;
	}
	
	@Override
	public void handleRequest(Request request) {
		if(request instanceof LeaveRequest)
			System.out.println("要请假，组长审批！");
		else
			rh.handleRequest(request);
	}

}
