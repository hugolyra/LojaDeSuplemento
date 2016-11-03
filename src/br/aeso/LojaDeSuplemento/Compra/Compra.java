package br.aeso.LojaDeSuplemento.Compra;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.aeso.LojaDeSuplemento.Cliente.Cliente;
import br.aeso.LojaDeSuplemento.Cupom.Cupom;
import br.aeso.LojaDeSuplemento.Suplementos.Suplemento;
import br.aeso.LojaDeSuplemento.Produtos.Produtos; 

public class Compra {
	private int id;
	private double preco;
	private Calendar date;
	private ArrayList<Suplemento> suplementos;
	private Cliente cliente;
	private Date data;
	private Cupom cupom;
	private int flag;
	
public Compra (int id, Calendar data, Cliente cliente){
	this.id = id;
	this.date = Calendar.getInstance();
	this.cliente = cliente;
	this.suplementos = new ArrayList<Suplemento>();
	this.date = new Date();
	this.cupom = new Cupom();
}

public Compra (){
	this.suplementos = new ArrayList<Suplemento>();
	this.date = Calendar.getInstance();
	this.date = new Date();
	this.setData();
	this.cupom = new Cupom();
}
	
public int getId(){
	return id;
}

public void setId(){
	this.id = id;
}

public Calendar getData(){
	return data;
}

public void setData(){
	this.date.setTime(date);
}

public ArrayList<Suplemento> getSuplementos(){
	return suplementos;
}

public void setSuplementos(Suplemento suplementos){
	this.suplementos.add(suplementos);
	this.setPreco();
}

public Cliente getCliente(){
	return cliente;
}

public void setCliente(Cliente cliente){
	this.cliente = cliente;
}

public double getPreco(){
	return this.preco;
}

public String getPrecoFormatado(){
	return "R$ " + this.preco;
}

public void setPreco(double preco){
	this.preco = preco - (preco * this.cupom.getValor());
}

public void setPreco(){
	double preco = 0;
	for (Suplemento suplemento : suplementos){
		preco = preco + suplemento.getPrecoVenda();
	}
	
}

public String dataFormatada() {
	DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	return df.format(this.data.getTime());
}

public String retornaSuplementos() {
	String listaSuplementos = "";
	for (Suplemento suplemento : suplementos) {
		listaSuplementos = listaSuplementos + suplementos.getId() + "\t" + suplementos.getNome()
				+ "\tR$ " + suplementos.getPrecoVenda() + "\n";
	}
	return listaSuplementos;
}

public Cupom getCupom() {
	return cupom;
}

public void setCupom(Cupom cupom) {
	this.cupom = cupom;
}

public int getFlag() {
	return flag;
}

public void setFlag(int flag) {
	this.flag = flag;
}

@Override
public String toString() {
	return "Compra id: " + id + "\nData da compra: " + this.dataFormatada()
			+ "\n" + cliente.getNome() + "\n" + retornaSuplementos()
		    + "Cupom " + this.getCupom().getValorFormatado() + "\nTotal: R$"
			+ this.getPreco();
	}
}
