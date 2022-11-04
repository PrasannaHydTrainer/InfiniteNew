package com.infinite.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote
{
	public String sayhello() throws RemoteException;
}
