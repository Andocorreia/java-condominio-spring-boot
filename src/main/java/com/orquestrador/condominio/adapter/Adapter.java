package com.orquestrador.condominio.adapter;

public interface Adapter<T, M> {

	T convert(M request);
}
