package controller;

import java.util.concurrent.Semaphore;

public class ThreadAviao extends Thread{

	private String aviao;
	private static int cta = 1;
	private Semaphore pista;
	private Semaphore semaforo;
	
	public ThreadAviao(String aviao, Semaphore semaforo, Semaphore pista) {
		
		this.semaforo = semaforo;
		this.pista = pista;
		this.aviao = aviao;
	}
	
	
	@Override
	public void run() {
		
		try {
			semaforo.acquire();
		
			validarPista();
			
			
			manobrar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		
		super.run();
	}


	private void validarPista() {
		try {
			pista.acquire();
			if(cta%2 == 0) {
				System.out.println("O avião " + aviao + " começou o processo de decolagem na pista Norte");
			}else {
				System.out.println("O avião " + aviao + " começou o processo de decolagem na pista Sul");
			}
			cta++;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			pista.release();
		}
		
		
	}


	private void manobrar() {
		
		try {
			sleep((int)((Math.random()*5001)+3000));
			System.out.println("O avião " + aviao + " acabou de manobrar");
			taxiar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void taxiar() {
		
		try {
			sleep((int)((Math.random()*5001)+5000));
			System.out.println("O avião " + aviao + " acabou de taxiar");
			decolar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	private void decolar() {
		
		try {
			sleep((int)((Math.random()*3001)+1000));
			System.out.println("O avião " + aviao + " acabou de decolar");
			afastamento();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	private void afastamento() {
		
		try {
			sleep((int)((Math.random()*5001)+3000));
			System.out.println("O avião " + aviao + " acabou de se afastar");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	
}