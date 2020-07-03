package com.exemplo.structural.proxy.proxy;

import com.exemplo.structural.proxy.original.ConcreteSubject;
import com.exemplo.structural.proxy.original.Subject;

public class Proxy implements Subject
{
    ConcreteSubject cs;
    @Override
    public void doSomeWork()
    {
        System.out.println("Chamada do Proxy acontecendo agora.");
        //Lazy initialization
        if (cs == null)
        {
            cs = new ConcreteSubject();
        }
        cs.doSomeWork();
    }
}
