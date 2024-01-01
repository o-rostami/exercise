package com.example.exercise.model;

import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Status {

	INITIATED(0), CONFIRMED(1), REJECTED(2);

	private final int value;


	public static Status fromValue(int value) {
		return Stream.of(Status.values()).filter(status -> status.value == value).findFirst().orElseThrow(() -> new IllegalArgumentException("invalid status found: " + value));
	}

}
