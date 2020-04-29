package com.jn.demo;

/**
 * 代表传输数据包的类型
 * <p>
 * 传输时，占用两个字节，即short即可。
 * <p>
 * [length][packetType][payload]
 */
public enum PacketType {

    /**
     * payload:
     *  [controlType][content]
     */
    CONTROL((short) 1),
    /**
     * payload:
     *  []()
     */
    FILE((short) 2),
    MESSAGE((short) 4),
    FORWARD((short) 8);

    private short code;

    private PacketType(short code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
