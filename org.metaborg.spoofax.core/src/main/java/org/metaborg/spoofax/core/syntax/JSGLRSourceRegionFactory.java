package org.metaborg.spoofax.core.syntax;

import org.metaborg.core.source.ISourceRegion;
import org.metaborg.core.source.SourceRegion;
import org.spoofax.jsglr.client.imploder.IToken;

public class JSGLRSourceRegionFactory {
    public static ISourceRegion fromToken(IToken token) {
        return new SourceRegion(token.getStartOffset(), token.getLine(), token.getColumn(), token.getEndOffset(),
            token.getEndLine(), token.getEndColumn());
    }

    public static ISourceRegion fromTokens(IToken left, IToken right) {
        return new SourceRegion(left.getStartOffset(), left.getLine(), left.getColumn(), right.getEndOffset(),
            right.getEndLine(), right.getEndColumn());
    }
    
    public static ISourceRegion fromTokensLayout(IToken left, IToken right) {
        int leftStartOffset = left.getStartOffset();
        int rightStartOffset = right.getStartOffset();
        int rightEndOffset = right.getEndOffset();
        
        if (rightEndOffset < rightStartOffset) 
            rightEndOffset = rightStartOffset;
        
        return new SourceRegion(leftStartOffset, left.getLine(), left.getColumn(), rightEndOffset,
            right.getEndLine(), right.getEndColumn());
    }
    
    
}
