package br.com.homine.roboto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "acp_Timesheet")
@Entity
public class TimeSheet {
	@Id
	@Column(name = "TimesheetID")
	private Long timeSheetId;
    
	@Column(name = "usuarioId" )
    private Long usuarioId;
	
    @Column(name = "ClienteID")
	private Long clienteId;
	
    @Column(name = "projetoID")
	private Long projetoId;
	
    @Column(name = "Data")
	private Date data;
	
    @Column(name = "Tempo")
	private Float tempo;
}
