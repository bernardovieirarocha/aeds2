#ifndef __IO_H__
#define __IO_H__

// --------------------------- Libs

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <stddef.h>
#include <ctype.h>


// --------------------------- Prototypes

/**
 * @anchor str_len
 * @brief Retorna o tamanho da string.
 * 
 * @param _Str String de entrada.
 * @return Tamanho da string (número de caracteres) ou -1 se _Str for NULL.
 */
int str_len ( const char *_Str );

/**
 * @anchor str_substring
 * @brief Retorna uma substring de _Str, começando em _Start até _End (inclusive).
 * 
 * @param _Str String de entrada.
 * @param _Start Índice inicial da substring.
 * @param _End Índice final da substring.
 * @return Ponteiro para a substring alocada dinamicamente ou NULL se _Str for NULL ou houver um erro de alocação.
 */
char* str_substring ( const char *_Str, size_t _Start, size_t _End );

/**
 * @anchor str_trim
 * @brief Remove espaços em branco, tabulações, novas linhas e retorno de carro à direita e à esquerda de _Str.
 * 
 * @param _Str String de entrada e saída.
 * @return Ponteiro para a string resultante da remoção dos espaços em branco ou NULL se _Str for NULL ou houver um erro de alocação.
 */
char* str_trim ( char *_Str );

/**
 * @anchor str_split
 * @brief Divide a string _Str em um array de strings utilizando o caractere delimitador _Delimiter.
 * 
 * @param _Str String a ser dividida.
 * @param _Delimiter Caractere delimitador.
 * @return Array de strings resultante da divisão ou NULL se houver um erro de alocação.
 */
char** str_split ( char *_Str, const char _Delimiter );

/**
 * @anchor str_dup 
 * @brief Retorna uma cópia alocada dinamicamente de _Str.
 * 
 * @param _Str String de entrada.
 * @return Ponteiro para a cópia de _Str ou NULL se _Str for NULL ou houver um erro de alocação.
 */
char* str_dup(const char *_Str);

/**
 * @anchor str_replace_c
 * @brief Substitui todas as ocorrências de _OldChar por _NewChar em _Str.
 * 
 * @param _Str String de entrada e saída.
 * @param _OldChar Caractere a ser substituído.
 * @param _NewChar Caractere substituto.
 * @return Ponteiro para a string resultante da substituição ou NULL se houver um erro de alocação.
 */
char* str_replace_c ( const char *_Str, const char _OldChar, const char _NewChar );

/**
 * @anchor str_contains
 * @brief Verifica se _Str contém a substring _Src.
 * 
 * @param _Str String de entrada.
 * @param _Src Substring a ser procurada.
 * @return true se _Str contém _Src, false caso contrário ou se _Str ou _Src forem NULL.
 */
bool str_contains ( const char *_Str, const char *_Src );

/**
 * @anchor str_equals
 * @brief Compara duas strings _Str1 e _Str2.
 * 
 * @param _Str1 Primeira string de entrada.
 * @param _Str2 Segunda string de entrada.
 * @return true se _Str1 é igual a _Str2, false caso contrário ou se _Str1 ou _Str2 forem NULL.
 */
bool str_equals ( const char *_Str1, const char *_Str2 );


bool str_contains (const char* _Str, const char* _Src)
{
    bool _Val = false;
    if( !_Str || !_Src ) {
        _Val = false;
    } 
    else 
    {
        size_t _Len_Str = str_len(_Str);
        size_t _Len_Src = str_len(_Src);

        for( size_t i = 0; i <= _Len_Str - _Len_Src; ++i ) 
        {
            bool found = true;
            for( size_t j = 0; j < _Len_Src; ++j ) 
            {
                if( _Str[i + j] != _Src[j] ) 
                {
                    found = false;
                    j = _Len_Src;
                } // end if
            } // end for
            if( found ) {
                _Val = true;
                i = _Len_Str - _Len_Src + 1;
            } // end if
        } // end for
    } // end if
    return ( _Val );
} // end str_contains ( )

bool str_equals ( const char *_Str1, const char *_Str2 )
{
    bool _Val = false;
    if( _Str1 && _Str2 )
    {
        _Val = true;
        size_t _Len1 = str_len(_Str1);
        size_t _Len2 = str_len(_Str2);
        if( _Len1 == _Len2 )
        {
            size_t _Var = 0;
            while( _Var < _Len1 ) 
            { 
                if( *(_Str1+_Var) != *(_Str2+_Var) ) 
                {
                    _Val = false;
                    _Var = _Len1;
                } // end if
                _Var = _Var + 1; 
            } // end while
        } // end if
    } // end if
    return ( _Val );
} // end str_equals ( )

#endif // __IO_H__