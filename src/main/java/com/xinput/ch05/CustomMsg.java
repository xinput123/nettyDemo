package com.xinput.ch05;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 自定义协议类
 * 我们规定两个系统通过Netty去发送这样的一个格式的信息，CustomMsg中包含这样的几类信息：
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomMsg {
    // 发送端的系统类型: 0xAB表示A系统、0xBC表示B系统
    private byte type;

    // 发送信息的类型: 0xAB心跳包、0xBC超时包、0xCD业务信息包
    private byte flag;

    // 主题信息的长度
    private int length;

    // 主题信息
    private String body;
}
