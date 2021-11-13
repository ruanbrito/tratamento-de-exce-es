package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) {
			// metodo para lançar a exceção
			// throw new IllegalArgumentException("Check-out date must be after check-in
			// date");

			// utilizando a classe para tratamento das exceções
			throw new DomainException("Check-out date must be after check-indate");
		}
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

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();

		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			// metodo para lançar a exceção
			// throw new IllegalArgumentException("Check-out date must be future dates");

			// utilizando a classe para tratamento das exceções
			throw new DomainException("Check-out date must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			// metodo para lançar a exceção
			// throw new IllegalArgumentException("Check-out date must be after check-in
			// date");

			// utilizando a classe para tratamento das exceções
			throw new DomainException("Check-out date must be after check-indate");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {
		return "Room" + roomNumber + ", Check-In: " + sdf.format(checkIn) + ", Check-Out" + sdf.format(checkOut) + ", "
				+ duration() + " nights";
	}
}
