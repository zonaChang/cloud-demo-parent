package com.carl.study.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author changez
 * @desc
 * @datetime 2019/8/14 12:33
 * @see FilterConstants
 */
public class AccessPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 路由之前过滤
        // @see FilterConstants
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 过滤器是否需要执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {

            // 验证失败, 则无需再路由到后续服务, 直接返回
            ctx.getResponse().setCharacterEncoding("UTF-8");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("没有token信息...");
        }
        System.out.println(ctx.getResponseBody());
        return ctx.getResponse();
    }
}
