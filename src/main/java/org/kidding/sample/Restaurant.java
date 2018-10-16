package org.kidding.sample;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class Restaurant {

//	private Chef chef;
	//요리사가 필요하지만 요리사를 직접 구하지 않음. Cook을 쓰네... Restaurant은 어떤 Checf가 오는지 모름 (실제 객체를 몰라도 괜춘. 인터페이스 타입이니)
	private Cook cook;
	
}
