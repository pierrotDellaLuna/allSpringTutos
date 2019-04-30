package ictcg.com.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Document  @Getter @Setter @EqualsAndHashCode
public class Societes {
	
	@Id
	private String  idSociete ;
	private String  name ;
	private double  marketValue ;
	
	
	public Societes(String name, double marketValue) {
		super();
		this.name = name;
		this.marketValue = marketValue;
	}
	
	
	

	

}
