#include <ctype.h>
#include <locale.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct types {
  char *type1;
  char *type2;
  int qtd;
} typedef types;

struct pokemon {
  char *id;
  int generation;
  char *name;
  char *description;
  types types;
  char *abilities;
  double weight;
  double height;
  int captureRate;
  int isLegendary;
  char *captureDate;
} typedef pokemon;

struct Pokedex {
  pokemon *pokemon;
  int tamanho;
  int capacidade;
} typedef Pokedex;

struct PokeList {
  pokemon *pokemon;
  int tamanho;
  int capacidade;
} typedef PokeList;

// --- Biblioteca de Funções Auxiliares

/**
 * @anchor str_len
 * @brief Retorna o tamanho da string.
 * 
 * @param _Str String de entrada.
 * @return Tamanho da string (número de caracteres) ou -1 se _Str for NULL.
 */
int str_len ( const char *_Str ){
    int _Len = -1;
    if( _Str )
    {
        _Len = 0;
        while( *(_Str+_Len) ) { _Len = _Len + 1; }
    } // end if
    return ( _Len );
} // end str_len ( )

/**
 * @anchor str_substring
 * @brief Retorna uma substring de _Str, começando em _Start até _End (inclusive).
 * 
 * @param _Str String de entrada.
 * @param _Start Índice inicial da substring.
 * @param _End Índice final da substring.
 * @return Ponteiro para a substring alocada dinamicamente ou NULL se _Str for NULL ou houver um erro de alocação.
 */
char* str_substring ( const char *_Str, size_t _Start, size_t _End )
{
    char *_Sub = NULL;
    size_t _Len_Str = str_len( _Str );
    if ( _Start < _Len_Str && _End < _Len_Str  && _Start <= _End )
    {
        size_t _Len = _End - _Start + 1;
        _Sub = (char*) malloc( (_Len+1) * sizeof(char) );
        if( _Sub )
        {
            size_t j = 0;
            for ( size_t i = _Start; i <= _End; i = i + 1, j = j + 1 ) {
                *(_Sub+j) = *(_Str+i);
            } // end for
            *(_Sub+j) = '\0';
        } // end if
    } // end if
    return ( _Sub );
} // end str_substring ( )

/**
 * @anchor str_dup 
 * @brief Retorna uma cópia alocada dinamicamente de _Str.
 * 
 * @param _Str String de entrada.
 * @return Ponteiro para a cópia de _Str ou NULL se _Str for NULL ou houver um erro de alocação.
 */
char* str_dup ( const char *_Str )
{
    char *_Dup = NULL;
    size_t _Var = 0;
    if( _Str )
    {
        _Dup = (char*) malloc( str_len(_Str)+1 * sizeof(char) );
        if( _Dup )
        {
            while( *(_Str+_Var) ) { *(_Dup+_Var) = *(_Str+_Var); _Var = _Var + 1; }
            *(_Dup+_Var) = '\0';
        } // end if
    } // end if
    return ( _Dup );
} // end str_dup ( )

/**
 * @anchor str_split
 * @brief Divide a string _Str em um array de strings utilizando o caractere delimitador _Delimiter.
 * 
 * @param _Str String a ser dividida.
 * @param _Delimiter Caractere delimitador.
 * @return Array de strings resultante da divisão ou NULL se houver um erro de alocação.
 */
char** str_split( char *_Str, const char _Delimiter )
{
    char** _Sequence = NULL;
    size_t _Size = 0;
    if( _Str )
    {
        size_t _Len_Str = str_len( _Str );
        // Contar a quantidade de delimitadores
        char *_Temp = _Str;
        while ( *_Temp )
        {
            if ( *_Temp == _Delimiter ) {
                _Size = _Size + 1;
            } // end if
            _Temp = _Temp + 1;
        } // end while
        _Size = _Size + 1; // Adicionar espaço NULL para terminação da Lista de Strings 

        _Sequence = (char**) malloc( _Size * sizeof(char*) );

        if ( _Sequence )
        {
            size_t _Var   = 0;
            size_t _Start = 0;
            size_t _End   = 0;
            while ( _Var < _Size )
            {
                while ( _End < _Len_Str && *(_Str+_End) != _Delimiter ) { _End++; }

                *(_Sequence+_Var) = str_substring( _Str, _Start, _End-1 );

                if ( *(_Sequence+_Var) == NULL ) {
                    *(_Sequence+_Var) = "";
                } // end if
                _Start = _End + 1; 
                _End = _Start;
                _Var++;
            } // end while
            *(_Sequence+_Var) = NULL;
        } // end if
    } // end if
    return ( _Sequence );
} // end str_split ( )

/**
 * @anchor str_trim
 * @brief Remove espaços em branco, tabulações, novas linhas e retorno de carro à direita e à esquerda de _Str.
 * 
 * @param _Str String de entrada e saída.
 * @return Ponteiro para a string resultante da remoção dos espaços em branco ou NULL se _Str for NULL ou houver um erro de alocação.
 */
char* str_trim(char* str) {
    char* end;

    // Trim leading space
    while (isspace((unsigned char)*str)) str++;

    if (*str == 0)  // All spaces?
        return str;

    // Trim trailing space
    end = str + strlen(str) - 1;
    while (end > str && isspace((unsigned char)*end)) end--;

    // Write new null terminator
    *(end + 1) = '\0';

    return str;
}

/**
 * @anchor str_replace_c
 * @brief Substitui todas as ocorrências de _OldChar por _NewChar em _Str.
 * 
 * @param _Str String de entrada e saída.
 * @param _OldChar Caractere a ser substituído.
 * @param _NewChar Caractere substituto.
 * @return Ponteiro para a string resultante da substituição ou NULL se houver um erro de alocação.
 */
char* str_replace_c ( const char *_Str, const char _OldChar, const char _NewChar )
{
    char* _Dest = NULL;
    if( _Str )
    {
        _Dest = str_dup(_Str);
        size_t _Var = 0;
        while( *(_Dest+_Var) )
        {
            if( *(_Dest+_Var) == _OldChar ) {
                *(_Dest+_Var) = _NewChar;
            } // end if
            _Var = _Var + 1;
        } // end while
    } // end if
    return ( _Dest );
} // end str_replace_c ( )


// Funcoes GET
char *getId(pokemon *p) { return p->id; }
int getGeneration(pokemon *p) { return p->generation; }
char *getName(pokemon *p) { return p->name; }
char *getDescription(pokemon *p) { return p->description; }
types getTypes(pokemon *p) { return p->types; }
char *getAbilities(pokemon *p) { return p->abilities; }
double getWeight(pokemon *p) { return p->weight; }
double getHeight(pokemon *p) { return p->height; }
int getCaptureRate(pokemon *p) { return p->captureRate; }
int getIsLegendary(pokemon *p) { return p->isLegendary; }
char *getCaptureDate(pokemon *p) { return p->captureDate; }
// Funcoes set
void setId(pokemon *p, char *id) { strcpy(p->id, id); }
void setGeneration(pokemon *p, int generation) { p->generation = generation; }
void setName(pokemon *p, char *name) { strcpy(p->name, str_trim(name)); }
void setDescription(pokemon *p, char *description) {
  strcpy(p->description, str_trim(description));
}
void setTypes(pokemon *p, types types) { p->types = types; }
void setAbilities(pokemon *p, char *abilities) {
  strcpy(p->abilities, abilities);
}
void setWeight(pokemon *p, double weight) { p->weight = weight; }
void setHeight(pokemon *p, double height) { p->height = height; }
void setCaptureRate(pokemon *p, int captureRate) {
  p->captureRate = captureRate;
}
void setIsLegendary(pokemon *p, int isLegendary) {
  p->isLegendary = isLegendary;
}
void setCaptureDate(pokemon *p, char *captureDate) {
  strcpy(p->captureDate, str_trim(captureDate));
}

// Verifica a existencia de espaço alocado para um pokemon
bool existePokemon(pokemon *p) {
  bool existe = false;

  if (p->id != NULL && p->name != NULL && p->description != NULL &&
      p->types.type1 != NULL && p->abilities != NULL &&
      p->captureDate != NULL) {
    existe = true;
  }
  return existe;
}

// Funcao para alocar a pokedex
Pokedex *alocatePokedex(void) {
  Pokedex *pokedex = (Pokedex *)malloc(sizeof(Pokedex));
  if (pokedex == NULL) {
    printf("Memory allocation error\n");
    exit(1);
  }
  pokedex->tamanho = 1;
  pokedex->pokemon = (pokemon *)malloc(
      1000 * sizeof(pokemon)); // Allocate space for 1000 Pokémon
  if (pokedex->pokemon == NULL) {
    printf("Memory allocation error\n");
    free(pokedex);
    exit(1);
  }
  return pokedex;
}

// Funcao para adicionar um pokemon na pokedex
void addPokemon(Pokedex *p, pokemon *poke) {
  p->pokemon[p->tamanho] = *poke;
  p->tamanho++;
}

// Desaloca um pokemon da memoria
void deletePokemon(pokemon *p) {
  if (existePokemon(p)) {
    free(p->id);
    free(p->name);
    free(p->description);
    free(p->types.type1);
    free(p->types.type2);
    free(p->abilities);
    free(p->captureDate);
    free(p);
  }
}

// Funcao para alocar um pokemon
pokemon *alocatePokemon(void) {
  pokemon *p = (pokemon *)malloc(sizeof(pokemon));
  if (p == NULL) {
    printf("Memory allocation error\n");
    return NULL;
  }
  // Allocate memory for strings
  p->id = (char *)calloc(10, sizeof(char));
  p->name = (char *)calloc(50, sizeof(char));
  p->description = (char *)calloc(100, sizeof(char));
  p->types.type1 = (char *)calloc(50, sizeof(char));
  p->types.type2 = (char *)calloc(50, sizeof(char));
  p->captureDate = (char *)calloc(50, sizeof(char));
  p->abilities = (char *)calloc(100, sizeof(char));

  // Check if the allocations were successful
  if (p->id == NULL || p->name == NULL || p->description == NULL ||
      p->types.type1 == NULL || p->abilities == NULL ||
      p->captureDate == NULL) {
    printf("Error to allocate memory for pokemon\n");
    free(p); // Free the struct memory if any allocation fails
    return NULL;
  }

  return p;
}

// Funcao para clonar um pokemon
pokemon *clonePokemon(pokemon *p) {
  pokemon *clone = alocatePokemon();
  if (existePokemon(p) && existePokemon(clone)) {
    setId(clone, getId(p));
    setGeneration(clone, getGeneration(p));
    setName(clone, getName(p));
    setDescription(clone, getDescription(p));
    setTypes(clone, getTypes(p));
    setAbilities(clone, getAbilities(p));
    setWeight(clone, getWeight(p));
    setHeight(clone, getHeight(p));
    setCaptureRate(clone, getCaptureRate(p));
    setIsLegendary(clone, getIsLegendary(p));
    setCaptureDate(clone, getCaptureDate(p));
  } else {
    printf("Error to clone pokemon\n");
  }
  return clone;
}

// Funcao para formatar as habilidades
void formatAbilities(char *abilities, pokemon *p) {
  abilities = str_replace_c(str_trim(abilities), '\"', ' ');
  abilities = str_replace_c(str_trim(abilities), '[', ' ');
  abilities = str_replace_c(str_trim(abilities), ']', ' ');
  abilities = str_replace_c(str_trim(abilities), '\'', ' ');
  abilities = str_trim(abilities);

  char *token = strtok(abilities, ",");

  char formattedAbilities[1024] = "['";

  while (token != NULL) {
    strcat(formattedAbilities, str_trim(token));
    token = strtok(NULL, ",");
    if (token != NULL) {
      strcat(formattedAbilities, "', '");
    }
  }
  strcat(formattedAbilities, "']");

  setAbilities(p, formattedAbilities);
}

// Funcao para printar um pokemon
void printPokemon(pokemon *p) {
  // Padrao de Impressao:
  // [#id -> name: description - [types] - [abilities] - weight - height -
  // captureRate - isLegendary - generation] - captureDate].
  printf("[#%s -> %s: %s - ", getId(p), getName(p), getDescription(p));
  if (getTypes(p).qtd == 1) {
    printf("['%s'] - ", getTypes(p).type1);
  } else {
    printf("['%s', '%s'] - ", getTypes(p).type1, getTypes(p).type2);
  }
  char *lendario = getIsLegendary(p) ? "true" : "false";
  printf("%s - %.1lfkg - %.1lfm - %d%% - %s - %d gen] - %s\n", getAbilities(p),
         getWeight(p), getHeight(p), getCaptureRate(p),
         getIsLegendary(p) ? "true" : "false", getGeneration(p),
         getCaptureDate(p));
}

// Funcao para inicializar um pokemon com os valores passados
void inicializarPokemon(pokemon *p, char *id, char *generation, char *name,
                        char *description, char *type1, char *type2,
                        char *abilities, char *weight, char *height,
                        char *captureRate, char *isLegendary,
                        char *captureDate) {
  if (existePokemon(p)) {
    setId(p, id);
    int gen = atoi(generation);
    setGeneration(p, gen);

    setName(p, name);
    setDescription(p, description);

    strcpy(p->types.type1, str_trim(type1));
    p->types.qtd = 1;
    if (type2 != NULL && type2[0] != '\0') {
      strcpy(p->types.type2, str_trim(type2));
      p->types.qtd = 2;
    } else {
      p->types.type2[0] = '\0';
    }

    formatAbilities(abilities, p);

    if (weight != NULL && weight[0] != '\0') {
      setWeight(p, atof(weight));
    } else {
      setWeight(p, 0.0);
    }
    if (height != NULL && height[0] != '\0') {

      setHeight(p, atof(height));

    } else {
      setHeight(p, 0.0);
    }

    if (captureRate != NULL && captureRate[0] != '\0') {
      setCaptureRate(p, atoi(captureRate));
    } else {
      setCaptureRate(p, 0);
    }

    if (isLegendary != NULL && isLegendary[0] != '\0') {
      setIsLegendary(p, atoi(isLegendary));
    } else {
      setIsLegendary(p, 0);
    }

    if (captureDate != NULL && captureDate[0] != '\0') {
      setCaptureDate(p, captureDate);
    } else {
      setCaptureDate(p, "0");
    }

  } else {
    printf("Error to inicialize pokemon\n");
  }
}

void lerCSV(Pokedex *pokedex, char *filename, char *id_search) {
  FILE *file = fopen(filename, "r");
  if (file == NULL) {
    printf("Error opening file\n");
    return;
  }

  char linha[500];

  // Ignora linha do cabecalho
  fgets(linha, sizeof(linha), file);

  while (fgets(linha, sizeof(linha), file) != NULL) {
    // Alocar um pokemon para armazenar os dados
    pokemon *poke = alocatePokemon();

    if (poke == NULL) {
      printf("Error to alocate pokemon\n");
      fclose(file);
      return;
    }

    // Substituir ',' por ';' para facilitar a leitura menos se for um "
    // dentro de lista
    bool dentroLista = false;
    for (int i = 0; i < strlen(linha); ++i) {

      if (!dentroLista && linha[i] == ',') {
        linha[i] = ';';
      } else if (linha[i] == '"') {
        dentroLista = !dentroLista;
      }
      // Remover quebra de linha
      if (linha[i] == '\n') {
        linha[i] = '\0';
      }
    }

    // Separa os campos ";"
    char **args = str_split(linha, ';');

    // Pegar o ID de maneira manual
    char id[4] = "";
    for (int i = 0; i < 3; i++) {
      if (linha[i] == ';') {
        break;
      }
      strncat(id, &linha[i], 1);
    }

    inicializarPokemon(poke, id, args[1], args[2], args[3], args[4], args[5],
                       args[6], args[7], args[8], args[9], args[10], args[11]);

    addPokemon(pokedex, poke);
  }
  fclose(file);
}

pokemon* procurarPokemon(Pokedex *pokedex, char *id) {
  for (int i = 0; i < pokedex->tamanho; i++) {
    if (getId(&pokedex->pokemon[i]) != NULL &&
        strcmp(getId(&pokedex->pokemon[i]), id) == 0) {
      return &pokedex->pokemon[i];
    }
  }
  return NULL;
}

void addPokemonList(PokeList *pokeList, pokemon *poke) {
  if (poke == NULL) {
    return;
  }
  pokeList->pokemon[pokeList->tamanho] = *poke;
  pokeList->tamanho++;
}

int main(void) {
  setlocale(LC_CTYPE, "UTF-8");

  Pokedex *pokedex = alocatePokedex();

  char *filename = "/tmp/pokemon.csv";
  lerCSV(pokedex, filename, "1");

  PokeList *pokeList = (PokeList *)malloc(sizeof(PokeList));
  pokeList->tamanho = 0;
  pokeList->capacidade = 1000;
  pokeList->pokemon = (pokemon *)malloc(pokeList->capacidade * sizeof(pokemon));

  char id[4];
  scanf("%s", id);
  while (strcmp(id, "FIM") != 0 && strcmp(id, "0") != 0) {
    addPokemonList(pokeList, procurarPokemon(pokedex, id));
    scanf("%s", id);
  }

  for (int i = 0; i < pokeList->tamanho; i++) {
    printPokemon(&pokeList->pokemon[i]);
  }

  
  return 0;
}