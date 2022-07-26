package ru.nf.conveyor.utils;

/**
 * Утилитный класс для расчета ежемесячного платежа
 */
public class CalcPenUtil {

	/**
	 * Метод для расчета ежемесячного платежа
	 *
	 * @param amount    сумма кредита
	 * @param monthRate процентная ставка за месяц
	 * @param period    период
	 * @return платеж
	 */
	public static Double calcPen(Double amount, Double monthRate, Integer period) {

		return amount * monthRate / (1 - (Math.pow(1 + monthRate, (-1) * period)));
	}
}
