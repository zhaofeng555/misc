package com.cor.test;

import com.cor.concretehandler.HRRequestHandle;
import com.cor.concretehandler.PMRequestHandle;
import com.cor.concretehandler.TLRequestHandle;
import com.cor.handler.RequestHandle;
import com.cor.request.Request;
import com.cor.requestimpl.AddMoneyRequest;
import com.cor.requestimpl.DimissionRequest;

public class CorTest {

	public static void main(String[] args) {
		RequestHandle hr = new HRRequestHandle();
		RequestHandle pm = new PMRequestHandle(hr);
		RequestHandle tl = new TLRequestHandle(pm);
		
		//team leader处理离职请求
		Request request = new DimissionRequest();
		tl.handleRequest(request);
		
		System.out.println("============");
		
		//team leader 处理加薪请求
		request = new AddMoneyRequest();
		tl.handleRequest(request);
		
		System.out.println("===========");
		//项目经理处理辞职请求
		request=new DimissionRequest();
		pm.handleRequest(request);
		
		
	}

}
