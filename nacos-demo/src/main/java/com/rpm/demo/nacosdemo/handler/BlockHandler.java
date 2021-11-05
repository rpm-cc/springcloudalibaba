package com.rpm.demo.nacosdemo.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class BlockHandler {
	// 注意1：返回值类型必须与业务方法的返回值类型相同
	// 注意2：参数必须有业务方法参数，且最后增加一个 BlockException exception
	// 注意3：此方法必须是static
    public static String handlerException( BlockException exception){
        return " 进行了限流";
    }
}
