package action.chainofresponsibility;

import action.chainofresponsibility.handler.HRRequestHandler;
import action.chainofresponsibility.handler.PMRequestHandler;
import action.chainofresponsibility.handler.RequestHandle;
import action.chainofresponsibility.handler.TLRequestHandler;
import action.chainofresponsibility.request.AddMoneyRequest;
import action.chainofresponsibility.request.DimissionRequest;
import action.chainofresponsibility.request.Request;

public class TestChofResp {

	public static void main(String[] args) {
		RequestHandle hr = new HRRequestHandler();
		RequestHandle pm = new PMRequestHandler(hr);
		RequestHandle tl = new TLRequestHandler(pm);
		
		//team leader 处理离职请求
		Request request = new DimissionRequest();
		tl.handleRequest(request);
		
		System.out.println("==========");
		
		//team leader 处理加薪请求
		request = new AddMoneyRequest();
		tl.handleRequest(request);
		
		System.out.println("==========");
		
		request=new DimissionRequest();
		pm.handleRequest(request);
	}
	
}
