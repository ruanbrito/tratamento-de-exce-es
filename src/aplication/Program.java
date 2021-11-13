package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner scn = new Scanner(System.in);
		
		try {
			System.out.print("Room number: ");
			int roomNumber = scn.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scn.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scn.next());
			System.out.println();
		
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scn.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scn.next());
		
			reservation.updateDates(checkIn, checkOut);
		
			System.out.println("Reservation: " + reservation);
			
		} catch (ParseException e) {
			System.out.println("Invalid date format!");			
		} catch (DomainException e) { //exceções personalizadas, que são esperadas.
			System.out.println("Error reservation: " + e.getMessage());
		} catch (RuntimeException e) { //exceções que nao estão sendo esperadas no programa e que podem aparecer
			System.out.println("Unexpected error");
		}
		
		
		scn.close();
	}

}
