// This is a generated file. Not intended for manual editing.
package org.elixir_lang.psi.impl;

import com.ericsson.otp.erlang.OtpErlangObject;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.elixir_lang.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElixirStabParenthesesSignatureImpl extends ASTWrapperPsiElement implements ElixirStabParenthesesSignature {

  public ElixirStabParenthesesSignatureImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ElixirVisitor visitor) {
    visitor.visitStabParenthesesSignature(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ElixirVisitor) accept((ElixirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ElixirEmptyParentheses getEmptyParentheses() {
    return PsiTreeUtil.getChildOfType(this, ElixirEmptyParentheses.class);
  }

  @Override
  @NotNull
  public ElixirParenthesesArguments getParenthesesArguments() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, ElixirParenthesesArguments.class));
  }

  @Override
  @Nullable
  public ElixirUnmatchedExpression getUnmatchedExpression() {
    return PsiTreeUtil.getChildOfType(this, ElixirUnmatchedExpression.class);
  }

  @Override
  @Nullable
  public ElixirUnqualifiedNoParenthesesManyArgumentsCall getUnqualifiedNoParenthesesManyArgumentsCall() {
    return PsiTreeUtil.getChildOfType(this, ElixirUnqualifiedNoParenthesesManyArgumentsCall.class);
  }

  @Override
  @Nullable
  public ElixirWhenInfixOperator getWhenInfixOperator() {
    return PsiTreeUtil.getChildOfType(this, ElixirWhenInfixOperator.class);
  }

  @Nullable
  public Quotable leftOperand() {
    return ElixirPsiImplUtil.leftOperand(this);
  }

  @NotNull
  public Operator operator() {
    return ElixirPsiImplUtil.operator(this);
  }

  @NotNull
  public OtpErlangObject quote() {
    return ElixirPsiImplUtil.quote(this);
  }

  @Nullable
  public Quotable rightOperand() {
    return ElixirPsiImplUtil.rightOperand(this);
  }

}
