package mage.cards.r;

import mage.MageInt;
import mage.abilities.common.SpellCastControllerTriggeredAbility;
import mage.abilities.effects.common.continuous.SetPowerToughnessSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubLayer;
import mage.constants.SubType;
import mage.filter.FilterSpell;
import mage.filter.predicate.mageobject.KickedPredicate;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class RisenRiptide extends CardImpl {

    private static final FilterSpell filter = new FilterSpell("a kicked spell");

    static {
        filter.add(KickedPredicate.instance);
    }

    public RisenRiptide(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{U}");

        this.subtype.add(SubType.ELEMENTAL);
        this.power = new MageInt(0);
        this.toughness = new MageInt(5);

        // Whenever you cast a kicked spell, Risen Riptide has base power and toughness 5/5 until end of turn.
        this.addAbility(new SpellCastControllerTriggeredAbility(new SetPowerToughnessSourceEffect(
                5, 5, Duration.EndOfTurn, SubLayer.SetPT_7b
        ).setText("{this} has base power and toughness 5/5 until end of turn"), filter, false));
    }

    private RisenRiptide(final RisenRiptide card) {
        super(card);
    }

    @Override
    public RisenRiptide copy() {
        return new RisenRiptide(this);
    }
}
