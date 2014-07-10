package com.cor.concretehandler;

import com.cor.handler.RequestHandle;
import com.cor.request.Request;
import com.cor.requestimpl.LeaveRequest;

public class TLRequestHandle implements RequestHandle {

	RequestHandle rh;
	
	public TLRequestHandle(RequestHandle rh){
		this.rh=rh;
	}
	
	@Override
	public void handleRequest(Request request) {
		if(request instanceof LeaveRequest){
			System.out.println("要请假，项目组长审批！");
		}else{
			rh.handleRequest(request);
		}
	}

}
