package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Player {

	private Integer id;
	private String name;
	private String nick;
	private LocalDate date;
	private Integer number;
	private String position;
	private Integer quality;
	private Integer card;
	private Boolean suspension;
	
	
	public Player() {
	
		setId(Integer.parseInt(JOptionPane.showInputDialog("ID: ")));
		setName(JOptionPane.showInputDialog("Name: "));
		setNick(JOptionPane.showInputDialog("Nick: "));
		
		Integer day= Integer.parseInt(JOptionPane.showInputDialog("Day of birth: "));
		Integer month = Integer.parseInt(JOptionPane.showInputDialog("Month of birth: "));
		Integer year= Integer.parseInt(JOptionPane.showInputDialog("Year of birth: "));
		LocalDate date = LocalDate.of(year, month, day);
		setDate(date);		
		setNumber(Integer.parseInt(JOptionPane.showInputDialog("Number: ")));
		setPosition(JOptionPane.showInputDialog("Position: "));
		setQuality(Integer.parseInt(JOptionPane.showInputDialog("Quality: ")));
		Integer cards=0;
		if(JOptionPane.showInputDialog("Have any card ou judge penalty?(Y/N) ").equals("y")) {
			Integer yellow = Integer.parseInt(JOptionPane.showInputDialog("How many yellow cards? "));
			cards+=yellow;
			if(JOptionPane.showInputDialog("Received a red card?(Y/N) ").equals("Y")) {
				cards+=3;
			}
			if(JOptionPane.showInputDialog("Received a judge penalty?(Y/N) ").equals("Y")) {
				cards+=3;
			}
			}
		setCard(cards);
		setCard(Integer.parseInt(JOptionPane.showInputDialog("Card's(Yellow +1, Red +3, Judge +3): ")));
		
		if(JOptionPane.showInputDialog("Suspension(Y/N: ").equals("Y")) {
			setSuspension(true);

		}else {
			setSuspension(false);
			}
	}

	public Player(Integer id, String name, String nick, LocalDate date, Integer number, String position,
			Integer quality, Integer card, Boolean suspension) {
		this.id = id;
		this.name = name;
		this.nick = nick;
		this.date = date;
		this.number = number;
		this.position = position;
		this.quality = quality;
		this.card = card;
		this.suspension = suspension;
	}
	
	public Boolean verification() {
		
		if(getCard()>=3) {
			return false;
		}else {
			return true;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public Integer getCard() {
		return card;
	}

	public void setCard(Integer card) {
		this.card = card;
	}

	public Boolean getSuspension() {
		return suspension;
	}

	public void setSuspension(Boolean suspension) {
		this.suspension = suspension;
	}

	@Override
	public String toString() {
		DateTimeFormatter x = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if(verification())
			return position + ": " + number + " - " + name + " ("+ nick + ") " + date.parse(date.toString(),x) + "CONDIÇÃO: TÁ PRA JOGO";
		else
			return position + ": " + number + " - " + name + " ("+ nick + ") " + date.parse(date.toString(),x) + "CONDIÇÃO: SUSPENSO";
	
	}
	
	
	
	
}
