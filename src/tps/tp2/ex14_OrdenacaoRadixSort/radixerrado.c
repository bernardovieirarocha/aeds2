#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

// Atributos de um pokemon
typedef struct
{
    int id;
    int generation;
    char name[80];
    char description[80];
    char type1[80];
    char type2[80];
    char abilities[200];
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    char captureDate[12];
} Pokemon;

// Declaração das funções
void printPokemon(const Pokemon *pokemon);
char *strsep(char **stringp, const char *delim);
void formatarString(char *str);
void adicionarPokemon(char *linha, Pokemon *pokemon);
void lerArquivo(const char *nomeArquivo, Pokemon pokemons[], int *totalPokemons);
int buscarPokemonID(int id, Pokemon pokemons[], int totalPokemons);

// Printar um pokemon em tal formato
void printPokemon(const Pokemon *pokemon)
{
    printf("[#%d -> %s: %s - ['%s'", 
           pokemon->id, 
           pokemon->name, 
           pokemon->description, 
           pokemon->type1);
    
    if (strcmp(pokemon->type2, "") != 0)
    {
        printf(", '%s']", pokemon->type2);
    } else
    {
        printf("]");
    }

    printf(" - %s - %.1fkg - %.1fm - %d%% - %s - %d gen] - %s", 
           pokemon->abilities, 
           pokemon->weight, 
           pokemon->height, 
           pokemon->captureRate, 
           pokemon->isLegendary ? "true" : "false", 
           pokemon->generation, 
           pokemon->captureDate);
}

// Função manual para strsep
char *strsep(char **stringp, const char *delim)
{
    char *start = *stringp;
    char *p;

    if (start == NULL)
    {
        return NULL;
    }

    p = strpbrk(start, delim);
    if (p)
    {
        *p = '\0';
        *stringp = p + 1;
    }
    else
    {
        *stringp = NULL;
    }

    return start;
}

// Retirar as " da string e substituir todas as , foras de [ ] por ; 
void formatarString(char *str)
{
    int dentroColchetes = 0;  
    int j = 0;  

    for (int i = 0; str[i] != '\0'; i++)
    {
        if (str[i] == '[')
        {
            dentroColchetes = 1;  
        } else if (str[i] == ']')
        {
            dentroColchetes = 0; 
        }

        if (str[i] == ',' && dentroColchetes == 0)
        {
            str[j++] = ';';
        }
        else if (str[i] != '"')
        {
            str[j++] = str[i];
        }
    }

    str[j] = '\0'; 
}

void adicionarPokemon(char *linha, Pokemon *pokemon)
{
    char *token;
    token = strsep(&linha, ";");
    pokemon->id = atoi(token);

    token = strsep(&linha, ";");
    pokemon->generation = atoi(token);

    token = strsep(&linha, ";");
    strcpy(pokemon->name, token);

    token = strsep(&linha, ";");
    strcpy(pokemon->description, token);

    token = strsep(&linha, ";");
    strcpy(pokemon->type1, token);

    token = strsep(&linha, ";");
    if (token[0] != 0) strcpy(pokemon->type2, token);

    token = strsep(&linha, ";");
    strcpy(pokemon->abilities, token);

    token = strsep(&linha, ";");
    pokemon->weight = atof(token);  

    token = strsep(&linha, ";");
    pokemon->height = atof(token);

    token = strsep(&linha, ";");
    pokemon->captureRate = atoi(token);

    token = strsep(&linha, ";");
    pokemon->isLegendary = atoi(token);  

    token = strsep(&linha, ";");
    strcpy(pokemon->captureDate, token);
}

void lerArquivo(const char *nomeArquivo, Pokemon pokemons[], int *totalPokemons)
{
    FILE *arquivo = fopen(nomeArquivo, "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo %s\n", nomeArquivo);
        return;
    }

    char linha[512];
    *totalPokemons = 0;

    while (fgets(linha, sizeof(linha), arquivo))
    {
        formatarString(linha);  
        adicionarPokemon(linha, &pokemons[*totalPokemons]);
        (*totalPokemons)++;
    }

    fclose(arquivo);
}

int buscarPokemonID(int id, Pokemon pokemons[], int totalPokemons)
{
    for (int i = 0; i < totalPokemons; i++)
    {
        if (pokemons[i].id == id)
        {
            return i;
        }
    }

    return -1;
}

int compareFirstAbility(const Pokemon *a, const Pokemon *b) {
    char firstA[80], firstB[80];
    sscanf(a->abilities, "%[^,]", firstA); 
    sscanf(b->abilities, "%[^,]", firstB); 

    int cmp = strcmp(firstA, firstB);
    if (cmp == 0) {
        return strcmp(a->name, b->name);
    }
    return cmp;
}

void radixCountingSort(Pokemon pokes[], int length) {
    Pokemon *output = (Pokemon *)malloc(length * sizeof(Pokemon));
    
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length - 1; j++) {
            if (compareFirstAbility(&pokes[j], &pokes[j + 1]) > 0) {
                Pokemon temp = pokes[j];
                pokes[j] = pokes[j + 1];
                pokes[j + 1] = temp;
            }
        }
    }

    free(output);
}

void radix(Pokemon pokes[], int tam) {
    radixCountingSort(pokes, tam);
}

int main(void)
{
    Pokemon pokemons[1000];
    int totalPokemons;

    lerArquivo("/tmp/pokemon.csv", pokemons, &totalPokemons);

    char input[15];
    int i=0;
    Pokemon NewPokemons[801];

    while (true)
    {
        scanf(" %s", input);
        
        if (strcmp(input, "FIM") == 0)
        {
            break;
        }

        int id = atoi(input);
        NewPokemons[i++] = pokemons[id];

    }

    radix(NewPokemons, i);

    for(int j =0;j<i;j++){
        printPokemon(&NewPokemons[j]);
    }
    
    return 0;
}