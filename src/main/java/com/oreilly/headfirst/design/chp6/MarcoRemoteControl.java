package com.oreilly.headfirst.design.chp6;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-09-26 09:22
 * @changeRecord
 */
public class MarcoRemoteControl {
    Command[] partyOn = {"lightOn", "stereoOn", "tvOn", "hottubOn"};
    Command[] partyOff = {"lightOff", "stereoOff", "tvOff", "hottubOff"};
    MarcoCommand partyOnMarco = new MarcoCommand(partyOn);
    MarcoCommand partyOffMarco = new MarcoCommand(partyOff);

}
