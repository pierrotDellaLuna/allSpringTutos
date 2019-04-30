package ictcg.com.model;

import java.time.Instant;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Document @Getter @Setter @EqualsAndHashCode 
public class TransactionFinance {
	
	@Id
	private String idTransaction ;
	private Instant instant ;
	private double price ;
	@JsonFormat (pattern="dd/MM/yyyy")
	private Date  todayDate ;
	@DBRef
	private Societes societe ;
	
	
	
	

}
