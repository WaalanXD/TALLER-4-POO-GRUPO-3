
import math
import tkinter as tk
from tkinter import messagebox

class CalculosNumericos:
    @staticmethod
    def logaritmo_neperiano(valor):
        if valor <= 0:
            raise ArithmeticError("El valor debe ser positivo.")
        return math.log(valor)

    @staticmethod
    def raiz_cuadrada(valor):
        if valor < 0:
            raise ArithmeticError("El valor debe ser positivo.")
        return math.sqrt(valor)

class InterfazCalculos:
    def __init__(self):
        self.ventana = tk.Tk()
        self.ventana.title("Cálculos Numéricos")
        self.ventana.geometry("320x220")
        self.ventana.config(bg="#f5f5f5")

        tk.Label(self.ventana, text="Ingrese un número:", bg="#f5f5f5", font=("Arial", 12)).pack(pady=10)
        self.entrada = tk.Entry(self.ventana, font=("Arial", 12))
        self.entrada.pack(pady=5)

        tk.Button(self.ventana, text="Calcular Logaritmo Neperiano", command=self.calcular_log, bg="#4CAF50", fg="white", font=("Arial", 10), width=25).pack(pady=8)
        tk.Button(self.ventana, text="Calcular Raíz Cuadrada", command=self.calcular_raiz, bg="#2196F3", fg="white", font=("Arial", 10), width=25).pack(pady=8)

        self.ventana.mainloop()

    def calcular_log(self):
        try:
            valor = float(self.entrada.get())
            resultado = CalculosNumericos.logaritmo_neperiano(valor)
            messagebox.showinfo("Resultado", f"Logaritmo neperiano de {valor} = {resultado:.5f}")
        except ValueError:
            messagebox.showerror("Error", "Por favor ingrese un número válido.")
        except ArithmeticError as e:
            messagebox.showerror("Error", str(e))

    def calcular_raiz(self):
        try:
            valor = float(self.entrada.get())
            resultado = CalculosNumericos.raiz_cuadrada(valor)
            messagebox.showinfo("Resultado", f"Raíz cuadrada de {valor} = {resultado:.5f}")
        except ValueError:
            messagebox.showerror("Error", "Por favor ingrese un número válido.")
        except ArithmeticError as e:
            messagebox.showerror("Error", str(e))


def iniciar_programa():
    InterfazCalculos()

iniciar_programa()
