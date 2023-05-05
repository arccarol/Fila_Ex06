package controller;

import java.util.concurrent.Semaphore;

import br.arccarol.filaObject.Fila;
import model.CriarFilas;

public class FilaController extends Thread  {
	private Semaphore semaforo1;
	private Semaphore semaforo2;
	Fila f = new Fila();
	private CriarFilas fila;
	private CriarFilas filap;
	
	public FilaController(CriarFilas fila, CriarFilas filap, Semaphore semaforo1, Semaphore semaforo2){
		this.semaforo1=semaforo1;
		this.semaforo2=semaforo2;
		this.fila =fila;
		this.filap=filap;
		
	}
	
		public void run() {
		CFila();
		Lista();
		try {
			semaforo1.acquire();
			remover(fila);
			semaforo2.acquire();
			remover(filap);
			
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
	}
	private void Lista() {
		try {
	f.list();
			System.out.println("");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		}

	private void remover(CriarFilas fila) {
		while (!f.isEmpty()) {
			try {
				Object c =f.remove();
				System.out.println(c);
			} catch (Exception e) {
				e.printStackTrace();
			}

				}
			
		}

	private void CFila() {
		f.insert(fila);
		f.insert(filap);
		
		
	}
	
		
		
}