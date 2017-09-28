package com.squareup.sqldelight.core.lang.psi

import com.alecstrong.sqlite.psi.core.SqliteAnnotationHolder
import com.alecstrong.sqlite.psi.core.psi.SqliteAnnotatedElement
import com.alecstrong.sqlite.psi.core.psi.SqliteIdentifier
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.squareup.sqldelight.core.lang.SqlDelightFile
import com.squareup.sqldelight.core.psi.SqlDelightStmtIdentifier

abstract class StmtIdentifierMixin(
    node: ASTNode
) : ASTWrapperPsiElement(node),
    SqlDelightStmtIdentifier,
    SqliteAnnotatedElement {
  override fun getName(): String? {
    return findChildByClass(SqliteIdentifier::class.java)?.text
  }

  override fun annotate(annotationHolder: SqliteAnnotationHolder) {
    (containingFile as SqlDelightFile).sqliteStatements()
  }
}
