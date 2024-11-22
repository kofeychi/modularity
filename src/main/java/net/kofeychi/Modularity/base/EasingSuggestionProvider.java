package net.kofeychi.Modularity.base;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.kofeychi.Modularity.DataUtil.EasingSelector;
import net.minecraft.server.command.ServerCommandSource;

import java.util.concurrent.CompletableFuture;

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
