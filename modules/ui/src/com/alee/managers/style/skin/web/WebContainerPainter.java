/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.managers.style.skin.web;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

/**
 * Base web-style painter for contaners.
 *
 * @param <E> component type
 * @param <U> component UI type
 * @author Mikle Garin
 */

public class WebContainerPainter<E extends JComponent, U extends ComponentUI> extends WebDecorationPainter<E, U>
{
    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isOpaque ()
    {
        // Returns null to disable panel automatic panel opacity changes by default
        // You may still provide a non-null opacity in your own implementations of PanelPainter
        return undecorated ? null : false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paint ( final Graphics2D g2d, final Rectangle bounds, final E c, final U ui )
    {
        // Paint simple background if undecorated & opaque
        if ( undecorated && c.isOpaque () )
        {
            g2d.setPaint ( c.getBackground () );
            g2d.fillRect ( bounds.x, bounds.y, bounds.width, bounds.height );
        }

        // Paint decoration if required
        super.paint ( g2d, bounds, c, ui );
    }
}