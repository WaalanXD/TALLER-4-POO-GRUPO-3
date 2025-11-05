
import math
import tkinter as tk
from tkinter import messagebox

class Programador:
    def __init__(self, nombre, apellido):
        self.validar_datos(nombre, apellido)
        self.nombre = nombre
        self.apellido = apellido

    def validar_datos(self, nombre, apellido):
        if not isinstance(nombre, str) or not isinstance(apellido, str):
            raise ValueError("Nombre y apellido deben ser texto.")
        if len(nombre) > 20 or len(apellido) > 20:
            raise ValueError("El nombre y apellido no deben superar 20 caracteres.")
        if any(char.isdigit() for char in nombre + apellido):
            raise ValueError("Nombre y apellido no deben contener números.")

class Equipo:
    def __init__(self, nombre_equipo, universidad, lenguaje, tamano):
        if tamano < 2 or tamano > 3:
            raise ValueError("El equipo debe tener entre 2 y 3 programadores.")
        self.nombre_equipo = nombre_equipo
        self.universidad = universidad
        self.lenguaje = lenguaje
        self.tamano = tamano
        self.programadores = []

    def esta_completo(self):
        return len(self.programadores) >= self.tamano

    def agregar_programador(self, programador):
        if self.esta_completo():
            raise Exception("El equipo ya está completo.")
        if not isinstance(programador, Programador):
            raise TypeError("Debe añadirse un objeto de tipo Programador.")
        self.programadores.append(programador)

class InterfazEquipo:
    def __init__(self):
        self.ventana = tk.Tk()
        self.ventana.title("Gestión de Equipo de Programadores")
        self.ventana.geometry("420x440")
        self.ventana.config(bg="#f5f5f5")

        tk.Label(self.ventana, text="Nombre del equipo:", bg="#f5f5f5").pack(pady=3)
        self.nombre_equipo = tk.Entry(self.ventana); self.nombre_equipo.pack(pady=2)
        tk.Label(self.ventana, text="Universidad:", bg="#f5f5f5").pack(pady=3)
        self.universidad = tk.Entry(self.ventana); self.universidad.pack(pady=2)
        tk.Label(self.ventana, text="Lenguaje:", bg="#f5f5f5").pack(pady=3)
        self.lenguaje = tk.Entry(self.ventana); self.lenguaje.pack(pady=2)
        tk.Label(self.ventana, text="Tamaño del equipo (2-3):", bg="#f5f5f5").pack(pady=3)
        self.tamano = tk.Entry(self.ventana); self.tamano.pack(pady=2)

        tk.Button(self.ventana, text="Crear Equipo", command=self.crear_equipo, bg="#4CAF50", fg="white", width=20).pack(pady=8)
        tk.Label(self.ventana, text="Agregar Programador", bg="#f5f5f5", font=("Arial", 10, "bold")).pack(pady=5)
        tk.Label(self.ventana, text="Nombre:", bg="#f5f5f5").pack(pady=2)
        self.nombre_prog = tk.Entry(self.ventana); self.nombre_prog.pack(pady=2)
        tk.Label(self.ventana, text="Apellido:", bg="#f5f5f5").pack(pady=2)
        self.apellido_prog = tk.Entry(self.ventana); self.apellido_prog.pack(pady=2)
        tk.Button(self.ventana, text="Añadir Programador", command=self.agregar_programador, bg="#2196F3", fg="white", width=20).pack(pady=8)

        tk.Button(self.ventana, text="Ver Equipo y Participantes", command=self.ver_equipo, bg="#9C27B0", fg="white", width=25).pack(pady=10)

        self.equipo = None
        self.ventana.mainloop()

    def crear_equipo(self):
        try:
            nombre = self.nombre_equipo.get()
            universidad = self.universidad.get()
            lenguaje = self.lenguaje.get()
            tamano = int(self.tamano.get())
            self.equipo = Equipo(nombre, universidad, lenguaje, tamano)
            messagebox.showinfo("Éxito", "Equipo creado correctamente.")
        except Exception as e:
            messagebox.showerror("Error", str(e))

    def agregar_programador(self):
        if not self.equipo:
            messagebox.showerror("Error", "Primero cree un equipo.")
            return
        try:
            nombre = self.nombre_prog.get()
            apellido = self.apellido_prog.get()
            nuevo = Programador(nombre, apellido)
            self.equipo.agregar_programador(nuevo)
            messagebox.showinfo("Éxito", f"Programador {nombre} {apellido} agregado.")
        except Exception as e:
            messagebox.showerror("Error", str(e))

    def ver_equipo(self):
        if not self.equipo:
            messagebox.showerror("Error", "No hay equipo creado.")
            return
        ventana_info = tk.Toplevel(self.ventana)
        ventana_info.title("Detalles del Equipo")
        ventana_info.geometry("350x300")
        ventana_info.config(bg="#eeeeee")

        tk.Label(ventana_info, text=f"Equipo: {self.equipo.nombre_equipo}", font=("Arial", 12, "bold"), bg="#eeeeee").pack(pady=5)
        tk.Label(ventana_info, text=f"Universidad: {self.equipo.universidad}", bg="#eeeeee").pack(pady=3)
        tk.Label(ventana_info, text=f"Lenguaje: {self.equipo.lenguaje}", bg="#eeeeee").pack(pady=3)
        tk.Label(ventana_info, text=f"Tamaño: {self.equipo.tamano}", bg="#eeeeee").pack(pady=3)
        tk.Label(ventana_info, text="Participantes:", font=("Arial", 11, "bold"), bg="#eeeeee").pack(pady=5)

        if not self.equipo.programadores:
            tk.Label(ventana_info, text="(Sin participantes aún)", bg="#eeeeee").pack()
        else:
            for p in self.equipo.programadores:
                tk.Label(ventana_info, text=f"- {p.nombre} {p.apellido}", bg="#eeeeee", font=("Arial", 10)).pack(anchor="w", padx=30)

InterfazEquipo()
