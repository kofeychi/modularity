package net.kofeychi.Modularity.base;
/*
 * ModularityAPI
 * Copyright (c) 2024. Kofeychi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.kofeychi.Modularity.DataUtil.EasingSelector;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;

import java.util.concurrent.CompletableFuture;
@SuppressWarnings("All")
@MethodsReturnNonnullByDefault
public class EasingSuggestionProvider implements SuggestionProvider<ServerCommandSource> {
    @Override
    public CompletableFuture<Suggestions> getSuggestions(CommandContext<ServerCommandSource> context, SuggestionsBuilder builder) throws CommandSyntaxException {

        builder.suggest(EasingSelector.EStringValues[0]);

        builder.suggest(EasingSelector.EStringValues[1]);
        builder.suggest(EasingSelector.EStringValues[2]);
        builder.suggest(EasingSelector.EStringValues[3]);

        builder.suggest(EasingSelector.EStringValues[4]);
        builder.suggest(EasingSelector.EStringValues[5]);
        builder.suggest(EasingSelector.EStringValues[6]);

        builder.suggest(EasingSelector.EStringValues[7]);
        builder.suggest(EasingSelector.EStringValues[8]);
        builder.suggest(EasingSelector.EStringValues[9]);

        builder.suggest(EasingSelector.EStringValues[10]);
        builder.suggest(EasingSelector.EStringValues[11]);
        builder.suggest(EasingSelector.EStringValues[12]);

        builder.suggest(EasingSelector.EStringValues[13]);
        builder.suggest(EasingSelector.EStringValues[14]);
        builder.suggest(EasingSelector.EStringValues[15]);

        builder.suggest(EasingSelector.EStringValues[16]);
        builder.suggest(EasingSelector.EStringValues[17]);
        builder.suggest(EasingSelector.EStringValues[18]);

        builder.suggest(EasingSelector.EStringValues[19]);
        builder.suggest(EasingSelector.EStringValues[20]);
        builder.suggest(EasingSelector.EStringValues[21]);

        builder.suggest(EasingSelector.EStringValues[22]);
        builder.suggest(EasingSelector.EStringValues[23]);
        builder.suggest(EasingSelector.EStringValues[24]);

        builder.suggest(EasingSelector.EStringValues[25]);
        builder.suggest(EasingSelector.EStringValues[26]);
        builder.suggest(EasingSelector.EStringValues[27]);

        // Lock the suggestions after we've modified them.
        return builder.buildFuture();
    }
}
