/*Um aeroporto tem 2 pistas (norte e sul) e, em cada pista, apenas um
avião pode fazer a decolagem.
O procedimento de decolagem tem 4 fases (manobra, taxiar,
decolagem e afastamento da área).
A fase de manobra pode durar de 3 a 7 segundos. A fase de taxiar, de 5
a 10 segundo. A fase de decolagem, de 1 a 4 segundos. A fase de
afastamento, de 3 a 8 segundos.
O aeroporto reúne, por ciclo, 12 aeronaves que podem decolar pela
pista norte ou pela pista sul (decisão aleatória). Mas, apenas 2 aviões
podem circular pela área de decolagem ao mesmo tempo.
Fazer uma aplicação em Java que resolva o problema.
*/

package view;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import controller.ThreadAviao;

public class Principal {
	
	public static void main(String[] args) {
		
		ArrayList<String> nomes = new ArrayList<>();

		nomes.add("Airbus A380");
		nomes.add("Boeing 707");
		nomes.add("IIyushin II-76");
		nomes.add("Antonov An-72");
		nomes.add("BAe 146");
		nomes.add("ATR 42");
		nomes.add("C-390 Millennium");
		nomes.add("An-225 Mriya");
		nomes.add("Sukhoi Superjet 100");
		nomes.add("Rainbow Azul");
		nomes.add("Embraer E-Jet");
		nomes.add("Bombardier CRJ");
		
		Semaphore semaforo = new Semaphore(2);
		Semaphore pista = new Semaphore(1);
		
		for (int i = 0; i < nomes.size(); i++) {
			
			Thread aviao = new ThreadAviao(nomes.get(i), semaforo, pista);
			aviao.start();
 			
		}
		
	}

}
