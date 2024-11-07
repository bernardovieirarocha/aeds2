#include <iostream>
#include <cstdio>
#include <queue>

class Dragao
{
public:
    int dias, multa;
    double prioridade;

    Dragao(int d, int m)
    {
        dias = d;
        multa = m;
        prioridade = (double) multa / dias;
    }

    bool operator <(const Dragao& a) const
    {
        return prioridade < a.prioridade;
    }
};

int main(void)
{
    int tempo, multa;
    double multadia = 0.0; // Multa paga por dia por todos os dragões
    double multatotal = 0.0; // Resposta
    bool treinando = false;
    int diasrestantes; // Tempo restante do treinamento
    std::priority_queue<Dragao> fila;

    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    while (std::cin >> tempo >> multa)
    {
        fila.push(Dragao(tempo, multa));
        multadia += multa;
        
        if (!treinando || !diasrestantes)
        {
            multadia -= fila.top().multa;
            diasrestantes = fila.top().dias;
            fila.pop();
            treinando = true;
        }
        multatotal += multadia;
        diasrestantes--;
    }

    if (treinando)
        multatotal +=  diasrestantes * multadia;

    while (!fila.empty()) {
        multadia -= fila.top().multa;
        multatotal += multadia * fila.top().dias;
        fila.pop();
    }

    printf("%.lf\n", multatotal);

    return 0;
}