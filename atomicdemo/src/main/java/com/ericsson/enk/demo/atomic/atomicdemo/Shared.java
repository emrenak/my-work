package com.ericsson.enk.demo.atomic.atomicdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class Shared {
	static AtomicInteger ai = new AtomicInteger(0);
}
