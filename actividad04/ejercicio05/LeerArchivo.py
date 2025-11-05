import io
import sys
from pathlib import Path
from typing import Optional
import tkinter as tk
from tkinter import filedialog, messagebox
from tkinter import ttk

APP_NAME = "Visor de Texto • Tk"
CODIFICACIONES = ["utf-8", "latin-1", "cp1252"]

def binario_a_cadena(archivo: Path, codif: str) -> str:
    with archivo.open("rb") as fh:
        with io.BufferedReader(fh) as buff:
            with io.TextIOWrapper(buff, encoding=codif, errors="replace") as txt:
                return txt.read()

class VisorTextoTK(tk.Tk):
    def __init__(self, ruta_inicial: Optional[Path] = None) -> None:
        super().__init__()
        self.title(APP_NAME)
        self.geometry("880x540")
        self.minsize(700, 400)
        self.codif_var = tk.StringVar(value=CODIFICACIONES[0])
        self._ruta_abierta: Optional[Path] = None
        self._construir_menu()
        self._construir_toolbar()
        self._construir_area_texto()
        self._construir_statusbar()
        self.bind_all("<Control-o>", lambda e: self.cmd_abrir())
        self.bind_all("<Control-l>", lambda e: self.cmd_limpiar())
        if ruta_inicial:
            self.cargar_desde_path(ruta_inicial)

    def _construir_menu(self) -> None:
        menu_bar = tk.Menu(self)
        m_archivo = tk.Menu(menu_bar, tearoff=False)
        m_archivo.add_command(label="Abrir…    Ctrl+O", command=self.cmd_abrir)
        m_archivo.add_separator()
        m_archivo.add_command(label="Salir", command=self.destroy)
        menu_bar.add_cascade(label="Archivo", menu=m_archivo)
        m_ver = tk.Menu(menu_bar, tearoff=False)
        m_ver.add_command(label="Limpiar     Ctrl+L", command=self.cmd_limpiar)
        menu_bar.add_cascade(label="Edición", menu=m_ver)
        self.config(menu=menu_bar)

    def _construir_toolbar(self) -> None:
        barra = ttk.Frame(self, padding=(8, 6))
        barra.pack(side=tk.TOP, fill=tk.X)
        ttk.Button(barra, text="Abrir…", command=self.cmd_abrir).pack(side=tk.LEFT)
        ttk.Button(barra, text="Limpiar", command=self.cmd_limpiar).pack(side=tk.LEFT, padx=(6, 0))
        ttk.Label(barra, text="Codificación:").pack(side=tk.LEFT, padx=(12, 4))
        self.cbo_codif = ttk.Combobox(barra, textvariable=self.codif_var, values=CODIFICACIONES, width=10, state="readonly")
        self.cbo_codif.pack(side=tk.LEFT)

    def _construir_area_texto(self) -> None:
        cont = ttk.Frame(self, padding=(8, 8))
        cont.pack(fill=tk.BOTH, expand=True)
        self.txt = tk.Text(cont, wrap="none", undo=True)
        s_y = ttk.Scrollbar(cont, orient="vertical", command=self.txt.yview)
        s_x = ttk.Scrollbar(cont, orient="horizontal", command=self.txt.xview)
        self.txt.configure(yscrollcommand=s_y.set, xscrollcommand=s_x.set)
        self.txt.grid(row=0, column=0, sticky="nsew")
        s_y.grid(row=0, column=1, sticky="ns")
        s_x.grid(row=1, column=0, sticky="ew")
        cont.columnconfigure(0, weight=1)
        cont.rowconfigure(0, weight=1)
        self.txt.insert("1.0", "Listo para leer. Usa Archivo → Abrir o Ctrl+O.\n")

    def _construir_statusbar(self) -> None:
        self.status_var = tk.StringVar(value="Listo")
        tk.Label(self, textvariable=self.status_var, anchor="w", relief=tk.SUNKEN).pack(side=tk.BOTTOM, fill=tk.X, padx=0, pady=0)

    def cmd_abrir(self) -> None:
        ruta = filedialog.askopenfilename(
            title="Selecciona un archivo de texto",
            filetypes=[("Texto", "*.txt *.csv *.log *.md *.json *.xml *.yml *.yaml *.py *.java"), ("Todos los archivos", "*.*")],
        )
        if ruta:
            self.cargar_desde_path(Path(ruta))

    def cmd_limpiar(self) -> None:
        self.txt.delete("1.0", tk.END)
        self.status_var.set("Listo")
        self._ruta_abierta = None

    def cargar_desde_path(self, p: Path) -> None:
        try:
            contenido = binario_a_cadena(p, self.codif_var.get())
        except FileNotFoundError:
            messagebox.showerror("No encontrado", f"No se pudo ubicar:\n{p}")
            return
        except PermissionError:
            messagebox.showerror("Permiso denegado", f"Sin permisos para:\n{p}")
            return
        except OSError as exc:
            messagebox.showerror("Error de lectura", f"{exc}")
            return
        self.txt.delete("1.0", tk.END)
        self.txt.insert(tk.END, contenido)
        lineas = 1 if contenido == "" else contenido.count("\n") + 1
        self._ruta_abierta = p
        self.status_var.set(f"Abierto: {p} — {lineas} líneas — {self.codif_var.get()}")

def main() -> None:
    ruta = Path(sys.argv[1]).expanduser() if len(sys.argv) > 1 else None
    app = VisorTextoTK(ruta)
    app.mainloop()      

if __name__ == "__main__":
    main()