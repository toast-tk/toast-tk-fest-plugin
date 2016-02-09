package com.synaptix.toast.adapter.swing;

import static com.synaptix.toast.core.adapter.ActionAdapterSentenceRef.AddValueInVar;
import static com.synaptix.toast.core.adapter.ActionAdapterSentenceRef.DiviserVarByValue;
import static com.synaptix.toast.core.adapter.ActionAdapterSentenceRef.MultiplyVarByValue;
import static com.synaptix.toast.core.adapter.ActionAdapterSentenceRef.RemplacerVarParValue;
import static com.synaptix.toast.core.adapter.ActionAdapterSentenceRef.SubstractValueFromVar;
import static com.synaptix.toast.core.adapter.ActionAdapterSentenceRef.VALUE_REGEX;

import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.ErrorResult;
import com.synaptix.toast.core.report.FailureResult;
import com.synaptix.toast.core.report.SuccessResult;
import com.synaptix.toast.dao.domain.api.test.ITestResult;
import com.synaptix.toast.runtime.IActionItemRepository;

@ActionAdapter(value = ActionAdapterKind.service, name = "default-common-adapter")
public abstract class AbstractCommonActionAdapter {

	protected IActionItemRepository repo;


	public AbstractCommonActionAdapter(
		IActionItemRepository repo) {
		this.repo = repo; 
	}


	@Action(action = AddValueInVar, description = "Additionner deux valeurs numériques")
	public ITestResult addValueToVar(
		String value,
		String var)
		throws Exception {
		Object object = repo.getUserVariables().get(var);
		if(object == null) {
			throw new IllegalAccessException("Variable not defined !");
		}
		if(object instanceof String) { // for the time being we store only
										// strings !!
			Double v = Double.valueOf(value);
			Double d = Double.valueOf((String) object);
			d = d + v;
			repo.getUserVariables().put(var, d.toString());
			return new SuccessResult(d.toString());
		}
		else {
			throw new IllegalAccessException("Variable not in a proper format: current -> "
				+ object.getClass().getSimpleName());
		}
	}

	@Action(action = SubstractValueFromVar, description = "Soustraire deux valeurs numériques")
	public ITestResult substractValueToVar(
		String value,
		String var)
		throws Exception {
		Object object = repo.getUserVariables().get(var);
		if(object == null) {
			throw new IllegalAccessException("Variable not defined !");
		}
		if(object instanceof String) { // for the time being we store only
										// strings !!
			Double v = Double.valueOf(value);
			Double d = Double.valueOf((String) object);
			d = d - v;
			repo.getUserVariables().put(var, d.toString());
			return new SuccessResult(d.toString());
		}
		else {
			throw new IllegalAccessException("Variable not in a proper format: current -> "
				+ object.getClass().getSimpleName());
		}
	}

	@Action(action = MultiplyVarByValue, description = "Multiplier deux valeurs")
	public ITestResult multiplyVarByBal(
		String var,
		String value)
		throws Exception {
		if(var == null) {
			throw new IllegalAccessException("Variable not defined !");
		}
		if(var instanceof String) { // for the time being we store only
									// strings !!
			Double v = Double.valueOf(value);
			Double d = Double.valueOf((String) var);
			d = d * v;
			return new SuccessResult(d.toString());
		}
		else {
			throw new IllegalAccessException("Variable not in a proper format: current -> " + var);
		}
	}

	@Action(action = DiviserVarByValue, description = "Diviseur le premier argument par le deuxième")
	public ITestResult divideVarByValue(
		String var,
		String value)
		throws Exception {
		if(var == null) {
			throw new IllegalAccessException("Variable not defined !");
		}
		if(var instanceof String) { // for the time being we store only
									// strings !!
			Double v = Double.valueOf(value);
			Double d = Double.valueOf(var);
			d = d / v;
			return new SuccessResult(d.toString());
		}
		else {
			throw new IllegalAccessException("Variable not in a proper format: current -> " + var);
		}
	}

	@Action(action = RemplacerVarParValue, description = "Assigner une valeur à une variable")
	public ITestResult replaceVarByVal(
		String var,
		String value)
		throws Exception {
		repo.getUserVariables().put(var, value);
		return new SuccessResult();
	}

	@Action(action = VALUE_REGEX + " == " + VALUE_REGEX, description = "Comparer deux variables")
	public ITestResult VarEqVar(
		String var1,
		String var2)
		throws Exception {
		if(var1.equals(var2)) {
			return new SuccessResult(Boolean.TRUE.toString());
		}
		else {
			return new FailureResult(String.format("%s == %s => %s", var1, var2, Boolean.FALSE.toString()));
		}
	}

	@Action(
		action = VALUE_REGEX + " égale à " + VALUE_REGEX,
		description = "Comparer une valeur à une variable")
	public ITestResult ValueEqVar(
		String value,
		String var)
		throws Exception {
		if(value.equals(var)) {
			return new SuccessResult(Boolean.TRUE.toString());
		}
		else {
			return new FailureResult(String.format("%s == %s => %s", value, var, Boolean.FALSE.toString()));
		}
	}

	@Action(action = "Assigner " + VALUE_REGEX + " à " + VALUE_REGEX, description = "Assigner valeur à variable")
	public com.synaptix.toast.dao.domain.api.test.ITestResult setValToVar(
		String value,
		String var)
		throws Exception {
		repo.getUserVariables().put(var, value);
		return new SuccessResult();
	}

}
