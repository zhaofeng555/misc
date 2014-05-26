package action.chainofresponsibility.handler;

import action.chainofresponsibility.request.Request;

public interface RequestHandle {

	void handleRequest(Request request);
	
}
