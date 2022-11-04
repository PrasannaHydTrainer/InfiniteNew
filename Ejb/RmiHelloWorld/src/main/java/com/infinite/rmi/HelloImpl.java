package com.infinite.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello
{
	public HelloImpl() throws Exception 
	{
		super();
	}
	public String sayhello() throws RemoteException
	{
		return "Hi Java Class in RMI";
	}
}
