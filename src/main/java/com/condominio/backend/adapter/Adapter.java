package com.condominio.backend.adapter;

public interface Adapter<T, M> {

	T convert(M request);
}
