# Nome: Bernardo Vieira Rocha
# Matrícula: 853733

import matplotlib.pyplot as plt
import numpy as np

# Dados dos arrays
sizes = [100, 1000, 10000]
sizes_labels = ['100', '1,000', '10,000']
x = np.arange(len(sizes_labels))  # Posições no eixo X
width = 0.2  # Largura das barras


# Colunas representam os diferentes tamanhos 0 a 100
# Arrays Aleatórios (ns)
aleatorio_primeiro = [15042, 195917, 3755791]
aleatorio_aleatorio = [22916, 216875, 517292]
aleatorio_mediana = [24083, 234708, 490167]

# Arrays Ordenados (ns)
ordenado_primeiro = [6750, 538000, 43944625]
ordenado_aleatorio = [3916, 40042, 278084]
ordenado_mediana = [2000, 20583, 94625]

# Arrays Quase Ordenados (ms)
quase_primeiro = [6250, 29166, 547333]
quase_aleatorio = [3083, 28000, 328250]
quase_mediana = [1708, 17625, 186083]

# Plotting Line Graphs
fig, axs = plt.subplots(1, 3, figsize=(18, 6))

# Gráfico 1: Arrays Aleatórios (Line)
axs[0].plot(sizes, aleatorio_primeiro, label='Primeiro Pivô', marker='o')
axs[0].plot(sizes, aleatorio_aleatorio, label='Pivô Aleatório', marker='o')
axs[0].plot(sizes, aleatorio_mediana, label='Mediana de Três', marker='o')
axs[0].set_title('Arrays Aleatórios')
axs[0].set_xlabel('Tamanho do Array')
axs[0].set_ylabel('Tempo de Execução (ns)')
axs[0].legend()
axs[0].grid(True)

# Gráfico 2: Arrays Ordenados (Line)
axs[1].plot(sizes, ordenado_primeiro, label='Primeiro Pivô', marker='o')
axs[1].plot(sizes, ordenado_aleatorio, label='Pivô Aleatório', marker='o')
axs[1].plot(sizes, ordenado_mediana, label='Mediana de Três', marker='o')
axs[1].set_title('Arrays Ordenados')
axs[1].set_xlabel('Tamanho do Array')
axs[1].set_ylabel('Tempo de Execução (ns)')
axs[1].legend()
axs[1].grid(True)

# Gráfico 3: Arrays Quase Ordenados (Line)
axs[2].plot(sizes, quase_primeiro, label='Primeiro Pivô', marker='o')
axs[2].plot(sizes, quase_aleatorio, label='Pivô Aleatório', marker='o')
axs[2].plot(sizes, quase_mediana, label='Mediana de Três', marker='o')
axs[2].set_title('Arrays Quase Ordenados')
axs[2].set_xlabel('Tamanho do Array')
axs[2].set_ylabel('Tempo de Execução (ms)')
axs[2].legend()
axs[2].grid(True)

# Ajustar layout
plt.tight_layout()
plt.show()

# Plotting Bar Graphs
fig, axs = plt.subplots(1, 3, figsize=(18, 6))

# Gráfico 1: Arrays Aleatórios (Bar)
axs[0].bar(x - width, aleatorio_primeiro, width, label='Primeiro Pivô')
axs[0].bar(x, aleatorio_aleatorio, width, label='Pivô Aleatório')
axs[0].bar(x + width, aleatorio_mediana, width, label='Mediana de Três')
axs[0].set_title('Arrays Aleatórios')
axs[0].set_xlabel('Tamanho do Array')
axs[0].set_ylabel('Tempo de Execução (ns)')
axs[0].set_xticks(x)
axs[0].set_xticklabels(sizes_labels)
axs[0].legend()

# Gráfico 2: Arrays Ordenados (Bar)
axs[1].bar(x - width, ordenado_primeiro, width, label='Primeiro Pivô')
axs[1].bar(x, ordenado_aleatorio, width, label='Pivô Aleatório')
axs[1].bar(x + width, ordenado_mediana, width, label='Mediana de Três')
axs[1].set_title('Arrays Ordenados')
axs[1].set_xlabel('Tamanho do Array')
axs[1].set_ylabel('Tempo de Execução (ns)')
axs[1].set_xticks(x)
axs[1].set_xticklabels(sizes_labels)
axs[1].legend()

# Gráfico 3: Arrays Quase Ordenados (Bar)
axs[2].bar(x - width, quase_primeiro, width, label='Primeiro Pivô')
axs[2].bar(x, quase_aleatorio, width, label='Pivô Aleatório')
axs[2].bar(x + width, quase_mediana, width, label='Mediana de Três')
axs[2].set_title('Arrays Quase Ordenados')
axs[2].set_xlabel('Tamanho do Array')
axs[2].set_ylabel('Tempo de Execução (ms)')
axs[2].set_xticks(x)
axs[2].set_xticklabels(sizes_labels)
axs[2].legend()

# Ajustar layout
plt.tight_layout()
plt.show()
