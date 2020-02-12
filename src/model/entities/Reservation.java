package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	/* public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	CheckIn n�o deve ser alterado livremente, por isso n�o pode ter setCheckIn
	 
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	Mesmo caso do setCheckIn
	*/
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // long pq o numero � um milisegundos. getTime � fun��o de tempo em Java
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Converte milisegundos em dias pelo TimeUnit
	}
	
	public String updateDates(Date checkin, Date checkout) {
		Date hoje = new Date();
		
		if (checkin.before(hoje) || (checkout.before(hoje))) {
			return "Erro na reserva! A data do Ckeck-out n�o pode ser anterior a data atual.";
		}
		if (!checkout.after(checkin)) {
			return "Erro na reserva! A data do Ckeck-out n�o pode ser anterior ao Check-in";
		}
		this.checkIn = checkin;
		this.checkOut = checkout;
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " noites.";
	}
	
}
