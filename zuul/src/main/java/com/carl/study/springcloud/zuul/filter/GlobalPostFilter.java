package com.carl.study.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author changez
 * @desc 异常处理器
 * @datetime 2019/8/15 15:02
 */
public class GlobalPostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        System.err.println("---------post filter-----------------" + ctx.getRouteHost()+"------------"+ctx.getResponseBody());
        return ctx.getResponse();
    }
}
