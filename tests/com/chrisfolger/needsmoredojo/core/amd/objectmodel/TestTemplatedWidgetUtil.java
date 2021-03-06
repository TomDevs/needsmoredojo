package com.chrisfolger.needsmoredojo.core.amd.objectmodel;

import com.chrisfolger.needsmoredojo.core.amd.objectmodel.TemplatedWidgetUtil;
import com.chrisfolger.needsmoredojo.testutil.BasicPsiElements;
import com.intellij.psi.PsiElement;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class TestTemplatedWidgetUtil
{
    @Test
    public void testRegexCorrectlyGeneratedFromAttachpoint()
    {
        PsiElement element = BasicPsiElements.expressionFromText("attachpoint");

        Pattern pattern = TemplatedWidgetUtil.getAttachPointStringFromReference(element)[0];
        assertEquals("data-dojo-attach-point=\\\"(\\w|,)*attachpoint\\w*\\\"", pattern.pattern());
    }

    @Test
    public void testRegexForLegacyAttachPointSyntaxIsGenerated()
    {
        PsiElement element = BasicPsiElements.expressionFromText("attachpoint");

        Pattern pattern = TemplatedWidgetUtil.getAttachPointStringFromReference(element)[1];
        assertEquals("dojoAttachPoint=\\\"(\\w|,)*attachpoint\\w*\\\"", pattern.pattern());
    }
}
