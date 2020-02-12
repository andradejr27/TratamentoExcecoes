package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date hoje = new Date();
		
		System.out.print("Numero do Quarto: ");
		int quarto = sc.nextInt();
		System.out.print("Data de Check-in (dd/mm/aaaa): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data de Check-out (dd/mm/aaaa): ");
		Date checkout = sdf.parse(sc.next());
		
		if (checkin.before(hoje) || (checkout.before(hoje))) {
			System.out.println("Erro na reserva! A data do Ckeck-out n�o pode ser anterior a data atual.");
		}
		
		if (!checkout.after(checkin)) {
			System.out.println("Erro na reserva! A data do Ckeck-out n�o pode ser anterior ao Check-in");
		}
		else {
			Reservation reserva = new Reservation(quarto, checkin, checkout);
			System.out.println("Reserva: " + reserva);
			System.out.println();
		}
		
		System.out.println("Digite as novas datas da reserva: ");
		System.out.print("Data de Check-in (dd/mm/aaaa): ");
		checkin = sdf.parse(sc.next());
		System.out.print("Data de Check-out (dd/mm/aaaa): ");
		checkout = sdf.parse(sc.next());
		
		if (checkin.before(hoje) || (checkout.before(hoje))) {
			System.out.println("Erro na reserva! A data do Ckeck-out n�o pode ser anterior a data atual.");
		}
		else {
			Reservation reserva = new Reservation(quarto, checkin, checkout);
			System.out.println("Reserva: " + reserva);
			System.out.println();
		}
		
		sc.close();
	}

}
