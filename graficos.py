import numpy as np
import matplotlib.pyplot as plt

tamanhos_de_vetor = np.array([1, 2, 4, 8, 16])
medias_custo_bubble = np.array([7497715291, 30025355026, 119963764397, 479906714998, 1919614549226])
medias_custo_selection = np.array([5000049982, 20000099992, 80000199990, 320000399990, 1280000799991])
medias_custo_insertion = np.array([4995530582, 20050910052, 79927928794, 319814229996, 1279230698452])

medias_custo_busca_linear = np.array([0, 0, ])
medias_custo_busca_binaria = np.array([0, 0, 80082038922,319882885107, 1280323734061])

plt.plot(tamanhos_de_vetor, medias_custo_bubble, label='Bubble', color='r')
plt.plot(tamanhos_de_vetor, medias_custo_selection, label='Selection', color='g')
plt.plot(tamanhos_de_vetor, medias_custo_insertion, label='Insertion', color='b')


plt.title('Custo x Tamanho')
plt.xlabel("Tamanho do vetor (*10^5)")
plt.ylabel("Médias do custo")
plt.legend()

plt.show()


